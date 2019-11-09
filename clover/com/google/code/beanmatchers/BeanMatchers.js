var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":110,"id":198,"methods":[{"el":36,"sc":3,"sl":13},{"el":39,"sc":3,"sl":38},{"el":43,"sc":3,"sl":41},{"el":47,"sc":3,"sl":45},{"el":52,"sc":3,"sl":49},{"el":56,"sc":3,"sl":54},{"el":60,"sc":3,"sl":58},{"el":64,"sc":3,"sl":62},{"el":68,"sc":3,"sl":66},{"el":72,"sc":3,"sl":70},{"el":76,"sc":3,"sl":74},{"el":80,"sc":3,"sl":78},{"el":84,"sc":3,"sl":82},{"el":88,"sc":3,"sl":86},{"el":92,"sc":3,"sl":90},{"el":96,"sc":3,"sl":94},{"el":100,"sc":3,"sl":98},{"el":105,"sc":3,"sl":102},{"el":109,"sc":3,"sl":107}],"name":"BeanMatchers","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_100":{"methods":[{"sl":41},{"sl":45}],"name":"testHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":42},{"sl":46}]},"test_11":{"methods":[{"sl":82}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":83}]},"test_110":{"methods":[{"sl":90}],"name":"testHasValidBeanEqualsExcluding","pass":true,"statements":[{"sl":91}]},"test_115":{"methods":[{"sl":94}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":95}]},"test_134":{"methods":[{"sl":86}],"name":"testHasValidBeanEqualsOnNonReflectedEquals","pass":true,"statements":[{"sl":87}]},"test_137":{"methods":[{"sl":70}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":71}]},"test_146":{"methods":[{"sl":13},{"sl":54},{"sl":62}],"name":"shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator","pass":true,"statements":[{"sl":14},{"sl":15},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":20},{"sl":21},{"sl":22},{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":28},{"sl":29},{"sl":35},{"sl":55},{"sl":63}]},"test_156":{"methods":[{"sl":54}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":55}]},"test_157":{"methods":[{"sl":45}],"name":"testBeanHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":46}]},"test_19":{"methods":[{"sl":49},{"sl":54},{"sl":58}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":50},{"sl":55},{"sl":59}]},"test_28":{"methods":[{"sl":102}],"name":"testHasValidBeanToStringExcluding","pass":true,"statements":[{"sl":103}]},"test_30":{"methods":[{"sl":74}],"name":"testHasValidBeanHashCodeFor","pass":true,"statements":[{"sl":75}]},"test_34":{"methods":[{"sl":86}],"name":"testHasValidBeanEqualsFor","pass":true,"statements":[{"sl":87}]},"test_35":{"methods":[{"sl":66}],"name":"testHasValidBeanConstructor","pass":true,"statements":[{"sl":67}]},"test_58":{"methods":[{"sl":49},{"sl":54}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":50},{"sl":55}]},"test_64":{"methods":[{"sl":78}],"name":"testHasValidBeanHashCodeExcluding","pass":true,"statements":[{"sl":79}]},"test_65":{"methods":[{"sl":54},{"sl":62},{"sl":107}],"name":"canRegisterCustomValueGenerator","pass":true,"statements":[{"sl":55},{"sl":63},{"sl":108}]},"test_89":{"methods":[{"sl":54},{"sl":62}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":55},{"sl":63}]},"test_90":{"methods":[{"sl":98}],"name":"testHasValidBeanToStringFor","pass":true,"statements":[{"sl":99}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [146], [], [], [], [], [], [146], [], [], [], [], [], [100], [100], [], [], [100, 157], [100, 157], [], [], [19, 58], [19, 58], [], [], [], [89, 146, 156, 65, 19, 58], [89, 146, 156, 65, 19, 58], [], [], [19], [19], [], [], [89, 146, 65], [89, 146, 65], [], [], [35], [35], [], [], [137], [137], [], [], [30], [30], [], [], [64], [64], [], [], [11], [11], [], [], [34, 134], [34, 134], [], [], [110], [110], [], [], [115], [115], [], [], [90], [90], [], [], [28], [28], [], [], [], [65], [65], [], []]
