var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":205,"id":752,"methods":[{"el":37,"sc":3,"sl":31},{"el":50,"sc":3,"sl":39},{"el":63,"sc":3,"sl":52},{"el":79,"sc":3,"sl":65},{"el":92,"sc":3,"sl":81},{"el":109,"sc":3,"sl":94},{"el":122,"sc":3,"sl":111},{"el":139,"sc":3,"sl":124},{"el":153,"sc":3,"sl":141},{"el":166,"sc":3,"sl":155},{"el":179,"sc":3,"sl":168},{"el":191,"sc":3,"sl":181},{"el":204,"sc":3,"sl":193}],"name":"HasToStringDescribingPropertiesExcludingMatcherTest","sl":18}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":168}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":171},{"sl":172},{"sl":175},{"sl":178}]},"test_103":{"methods":[{"sl":111}],"name":"beanWithoutPropertyNameInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":118},{"sl":121}]},"test_105":{"methods":[{"sl":124}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":127},{"sl":128},{"sl":131},{"sl":134},{"sl":135},{"sl":136},{"sl":137},{"sl":138}]},"test_118":{"methods":[{"sl":81}],"name":"beanWithoutPropertyNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":84},{"sl":85},{"sl":88},{"sl":91}]},"test_132":{"methods":[{"sl":52}],"name":"beanWithoutClassNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":55},{"sl":56},{"sl":59},{"sl":62}]},"test_145":{"methods":[{"sl":181}],"name":"shouldDescribeExpectation","pass":true,"statements":[{"sl":184},{"sl":187},{"sl":190}]},"test_151":{"methods":[{"sl":193}],"name":"shouldDescribeExpectationForExcludedProperties","pass":true,"statements":[{"sl":196},{"sl":199},{"sl":202},{"sl":203}]},"test_25":{"methods":[{"sl":65}],"name":"beanWithoutClassNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":68},{"sl":69},{"sl":72},{"sl":75},{"sl":76},{"sl":77},{"sl":78}]},"test_4":{"methods":[{"sl":94}],"name":"beanWithoutPropertyNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":97},{"sl":98},{"sl":101},{"sl":104},{"sl":105},{"sl":106},{"sl":107},{"sl":108}]},"test_43":{"methods":[{"sl":39}],"name":"beanWithValidToStringShouldMatch","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":46},{"sl":49}]},"test_70":{"methods":[{"sl":155}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":158},{"sl":159},{"sl":162},{"sl":165}]},"test_74":{"methods":[{"sl":141}],"name":"beanWithoutArrayPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":144},{"sl":145},{"sl":146},{"sl":149},{"sl":152}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [43], [], [], [43], [43], [], [], [43], [], [], [43], [], [], [132], [], [], [132], [132], [], [], [132], [], [], [132], [], [], [25], [], [], [25], [25], [], [], [25], [], [], [25], [25], [25], [25], [], [], [118], [], [], [118], [118], [], [], [118], [], [], [118], [], [], [4], [], [], [4], [4], [], [], [4], [], [], [4], [4], [4], [4], [4], [], [], [103], [], [], [103], [103], [], [], [103], [], [], [103], [], [], [105], [], [], [105], [105], [], [], [105], [], [], [105], [105], [105], [105], [105], [], [], [74], [], [], [74], [74], [74], [], [], [74], [], [], [74], [], [], [70], [], [], [70], [70], [], [], [70], [], [], [70], [], [], [1], [], [], [1], [1], [], [], [1], [], [], [1], [], [], [145], [], [], [145], [], [], [145], [], [], [145], [], [], [151], [], [], [151], [], [], [151], [], [], [151], [151], [], []]
