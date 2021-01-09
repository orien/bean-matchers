var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":22,"id":1448,"methods":[{"el":21,"sc":3,"sl":11}],"name":"MockingTypeBasedValueGeneratorTest","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_20":{"methods":[{"sl":11}],"name":"testGenerate","pass":true,"statements":[{"sl":14},{"sl":17},{"sl":20}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [20], [], [], [20], [], [], [20], [], [], [20], [], []]
