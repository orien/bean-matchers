var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":28,"id":380,"methods":[{"el":17,"sc":3,"sl":13},{"el":22,"sc":3,"sl":19},{"el":27,"sc":3,"sl":24}],"name":"HasToStringDescribingPropertiesMatcher","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_120":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutArrayPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_128":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutPropertyNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_142":{"methods":[{"sl":13},{"sl":24}],"name":"shouldDescribeExpectationForExcludedProperties","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":25},{"sl":26}]},"test_27":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_44":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutClassNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_48":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_54":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutClassNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_85":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutPropertyNameInToStringShouldMatchIfPropertyNotDeclared","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_9":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsNotDeclared","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_90":{"methods":[{"sl":13},{"sl":19}],"name":"testHasValidBeanToStringFor","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_93":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithValidToStringShouldMatch","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]},"test_96":{"methods":[{"sl":13},{"sl":19}],"name":"beanWithoutPropertyNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":15},{"sl":16},{"sl":21}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [44, 142, 27, 93, 54, 96, 85, 9, 90, 128, 48, 120], [], [44, 142, 27, 93, 54, 96, 85, 9, 90, 128, 48, 120], [44, 142, 27, 93, 54, 96, 85, 9, 90, 128, 48, 120], [], [], [44, 27, 93, 54, 96, 85, 9, 90, 128, 48, 120], [], [44, 27, 93, 54, 96, 85, 9, 90, 128, 48, 120], [], [], [142], [142], [142], [], []]
