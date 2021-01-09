var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":14,"id":1872,"methods":[{"el":9,"sc":3,"sl":7},{"el":13,"sc":3,"sl":11}],"name":"TestBeanWithPropertyNeedingCustomGenerator","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_120":{"methods":[{"sl":7},{"sl":11}],"name":"canRegisterCustomValueGenerator","pass":true,"statements":[{"sl":8},{"sl":12}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [120], [120], [], [], [120], [120], [], []]
