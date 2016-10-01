var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":53,"id":1235,"methods":[{"el":23,"sc":5,"sl":19},{"el":32,"sc":5,"sl":25},{"el":41,"sc":5,"sl":34},{"el":51,"sc":5,"sl":43}],"name":"InMemoryValueGeneratorRepositoryTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_117":{"methods":[{"sl":25}],"name":"canRegisterValueGenerator","pass":true,"statements":[{"sl":28},{"sl":31}]},"test_31":{"methods":[{"sl":43}],"name":"canRegisterValueGeneratorForTwoTypes","pass":true,"statements":[{"sl":46},{"sl":49},{"sl":50}]},"test_41":{"methods":[{"sl":34}],"name":"shouldNotRegisterValueGeneratorForDifferingType","pass":true,"statements":[{"sl":37},{"sl":40}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [117], [], [], [117], [], [], [117], [], [], [41], [], [], [41], [], [], [41], [], [], [31], [], [], [31], [], [], [31], [31], [], [], []]
