var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":5,"id":1660,"methods":[{"el":4,"sc":5,"sl":4}],"name":"TestBeanWithPrivateConstructor","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_39":{"methods":[{"sl":4}],"name":"canInstantiateClassUsingPrivateNoArgsConstructor","pass":true,"statements":[]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [39], []]
