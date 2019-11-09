var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":345,"methods":[{"el":10,"sc":3,"sl":7},{"el":14,"sc":3,"sl":12},{"el":18,"sc":3,"sl":16}],"name":"DistinctValues","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingEqualsShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_10":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithValidHashCodeShouldMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_102":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_104":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingEqualsShouldBeDiagnosed","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_11":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_110":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"testHasValidBeanEqualsExcluding","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_117":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithValidEqualsShouldMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_123":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingNullPropertyShouldBeDiagnosed","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_129":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"canGenerateTwoValues","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_133":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_134":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"testHasValidBeanEqualsOnNonReflectedEquals","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_137":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_144":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"shouldGenerateTwoDistinctValues","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_148":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingEqualsShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_15":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingEqualsShouldBeDiagnosed","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_165":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingSamePropertyValuesShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_17":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingThisNullPropertyShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_18":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingThatNullPropertyShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_24":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_29":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingThisNullPropertyShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_34":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"testHasValidBeanEqualsFor","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_39":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithValidHashCodeShouldMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_41":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingNullPropertyShouldBeDiagnosed","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_55":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithValidEqualsShouldMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_59":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingSamePropertyValuesShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_60":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_77":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingEqualsShouldMatchIfBadPropertyIsExcluded","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_8":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithPropertyNotInfluencingEqualsShouldMatchIfBadPropertyIsNotIncluded","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]},"test_80":{"methods":[{"sl":7},{"sl":12},{"sl":16}],"name":"beanWithEqualsNotHandlingThatNullPropertyShouldNotMatch","pass":true,"statements":[{"sl":8},{"sl":9},{"sl":13},{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [], [], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [], [], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [0, 104, 77, 133, 8, 137, 39, 34, 60, 24, 148, 80, 110, 41, 102, 59, 134, 11, 117, 55, 17, 129, 18, 144, 15, 165, 123, 10, 29], [], []]
