var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":40,"id":674,"methods":[{"el":20,"sc":3,"sl":17},{"el":29,"sc":3,"sl":22},{"el":39,"sc":3,"sl":31}],"name":"ByteGeneratorTest","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_133":{"methods":[{"sl":22}],"name":"shouldProvideValue","pass":true,"statements":[{"sl":25},{"sl":28}]},"test_143":{"methods":[{"sl":31}],"name":"shouldProvideDifferingValueOnSubsequentCall","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":38}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [133], [], [], [133], [], [], [133], [], [], [143], [], [], [143], [143], [], [], [143], [], []]
