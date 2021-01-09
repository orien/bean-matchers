var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":45,"id":1684,"methods":[{"el":12,"sc":3,"sl":10},{"el":16,"sc":3,"sl":14},{"el":34,"sc":3,"sl":18},{"el":39,"sc":3,"sl":36},{"el":44,"sc":3,"sl":41}],"name":"TestBeanWithListProperty","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_79":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithValidGettersAndSettersForListShouldMatch","pass":true,"statements":[{"sl":11},{"sl":15}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [79], [79], [], [], [79], [79], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
