var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":38,"id":634,"methods":[{"el":18,"sc":5,"sl":15},{"el":27,"sc":5,"sl":20},{"el":37,"sc":5,"sl":29}],"name":"CharacterGeneratorTest","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_100":{"methods":[{"sl":20}],"name":"shouldProvideValue","pass":true,"statements":[{"sl":23},{"sl":26}]},"test_109":{"methods":[{"sl":29}],"name":"shouldProvideDifferingValueOnSubsequentCall","pass":true,"statements":[{"sl":32},{"sl":33},{"sl":36}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [100], [], [], [100], [], [], [100], [], [], [109], [], [], [109], [109], [], [], [109], [], []]
