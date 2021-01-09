var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":43,"id":1931,"methods":[{"el":25,"sc":3,"sl":9},{"el":29,"sc":3,"sl":27},{"el":33,"sc":3,"sl":31},{"el":37,"sc":3,"sl":35},{"el":41,"sc":3,"sl":39}],"name":"TestBeanWithTwoPropertiesAndNonReflectedEquals","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_160":{"methods":[{"sl":9},{"sl":27},{"sl":31},{"sl":35},{"sl":39}],"name":"testHasValidBeanEqualsOnNonReflectedEquals","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":14},{"sl":15},{"sl":17},{"sl":18},{"sl":20},{"sl":21},{"sl":28},{"sl":32},{"sl":36},{"sl":40}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [160], [], [160], [160], [], [160], [160], [], [160], [160], [], [160], [160], [], [], [], [], [], [160], [160], [], [], [160], [160], [], [], [160], [160], [], [], [160], [160], [], [], []]
