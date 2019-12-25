
网关流控（官方文档）：https://github.com/alibaba/Sentinel/wiki/%E7%BD%91%E5%85%B3%E9%99%90%E6%B5%81

Sentinel 1.6.0 引入了 Sentinel API Gateway Adapter Common 模块，此模块中包含网关限流的规则和自定义 API 的实体和管理逻辑：

**GatewayFlowRule**：网关限流规则，针对 API Gateway 的场景定制的限流规则，可以
- 针对不同 `route` 
- 针对自定义的 `API分组`进行限流
- 针对请求中的参数、Header、来源 IP 等进行定制化的限流。

**ApiDefinition**：用户自定义的 API 定义分组，可以看做是一些 URL 匹配的组合。比如我们可以定义一个 API 叫 my_api，请求 path 模式为 /foo/ 和 /baz/ 的都归到 my_api 这个 API 分组下面。限流的时候可以针对这个自定义的 API 分组维度进行限流。对于API分组的配置，主要是就是在定义 `ApiPredicateItem` 的列表

其中网关限流规则 GatewayFlowRule 的字段解释如下：

- `resource`：资源名称，可以是网关中的 route 名称或者用户自定义的 API 分组名称。
- `resourceMode`：规则是针对 API Gateway 的 route（RESOURCE_MODE_ROUTE_ID）还是用户在 Sentinel 中定义的 API 分组（RESOURCE_MODE_CUSTOM_API_NAME），默认是 route。
- `grade`：限流指标维度，同限流规则的 grade 字段
- `count`：限流阈值
- `intervalSec`：统计时间窗口，单位是秒，默认是 1 秒
- `controlBehavior`：流量整形的控制效果，同限流规则的 controlBehavior 字段，目前支持快速失败和匀速排队两种模式，默认是快速失败。
- `burst`：应对突发请求时额外允许的请求数目。
- `maxQueueingTimeoutMs`：匀速排队模式下的最长排队时间，单位是毫秒，仅在匀速排队模式下生效。
- `paramItem`：参数限流配置。若不提供，则代表不针对参数进行限流，该网关规则将会被转换成普通流控规则；否则会转换成热点规则。其中的字段：
- `parseStrategy`：从请求中提取参数的策略，目前支持提取来源 IP（PARAM_PARSE_STRATEGY_CLIENT_IP）、Host（PARAM_PARSE_STRATEGY_HOST）、任意 Header（PARAM_PARSE_STRATEGY_HEADER）和任意 URL 参数（PARAM_PARSE_STRATEGY_URL_PARAM）四种模式。
- `fieldName`：若提取策略选择 Header 模式或 URL 参数模式，则需要指定对应的 header 名称或 URL 参数名称。
- `pattern` 和 `matchStrategy`：为后续参数匹配特性预留，目前未实现。

用户可以通过 `GatewayRuleManager.loadRules(rules)` 手动加载网关规则，或通过 `GatewayRuleManager.register2Property(property)` 注册动态规则源动态推送（推荐方式）


**代码的分组定义 && 分组限流定义**

```
		// 配置分组
        Set<ApiDefinition> apiDefinitionSet = new HashSet<>();

        ApiDefinition apiDefinition = new ApiDefinition();
        apiDefinition.setApiName("sentinel-zuul-test");
        Set<ApiPredicateItem> predicateItemSet = new HashSet<>();
        ApiPathPredicateItem predicateItem = new ApiPathPredicateItem();
        predicateItem.setMatchStrategy(1);
        predicateItem.setPattern("/consumer/**");
        predicateItemSet.add(predicateItem);
        apiDefinition.setPredicateItems(predicateItemSet);
        apiDefinitionSet.add(apiDefinition);
        GatewayApiDefinitionManager.loadApiDefinitions(apiDefinitionSet);
        
        Set<GatewayFlowRule> gatewayFlowRuleSet = new HashSet<>();
         // 测试按配置分组限流
        GatewayFlowRule gatewayFlowRule = new GatewayFlowRule();
        gatewayFlowRule.setResource("sentinel-zuul-test");
        gatewayFlowRule.setCount(2);
        gatewayFlowRuleSet.add(gatewayFlowRule);
```















