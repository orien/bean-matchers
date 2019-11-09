var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":47,"id":567,"methods":[{"el":20,"sc":3,"sl":10},{"el":32,"sc":3,"sl":22},{"el":46,"sc":3,"sl":34}],"name":"BeanMatchersExceptionTest","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_109":{"methods":[{"sl":22}],"name":"canCreateExceptionWithCause","pass":true,"statements":[{"sl":25},{"sl":28},{"sl":31}]},"test_127":{"methods":[{"sl":34}],"name":"canCreateExceptionWithMessageAndCause","pass":true,"statements":[{"sl":37},{"sl":38},{"sl":41},{"sl":44},{"sl":45}]},"test_3":{"methods":[{"sl":10}],"name":"canCreateExceptionWithMessage","pass":true,"statements":[{"sl":13},{"sl":16},{"sl":19}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [3], [], [], [3], [], [], [3], [], [], [3], [], [], [109], [], [], [109], [], [], [109], [], [], [109], [], [], [127], [], [], [127], [127], [], [], [127], [], [], [127], [127], [], []]
