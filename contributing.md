I :heart: pull requests. Here's a quick guide:

1. Fork the repo.

2. Run the tests. Pull requests will only be accepted when all tests pass,
and it's great to know that everything is running correctly: `mvn test`

3. Add a test for your change. Only refactoring and documentation changes
require no new tests. If you are adding functionality or fixing a bug, we need
a test!

4. Make the test pass.

5. Push to your fork and submit a pull request.


At this point you're waiting on me. I like to at least comment on, if not
accept, pull requests within three business days (and, typically, one business
day). I may suggest some changes or improvements or alternatives.

Some things that will increase the chance that your pull request is accepted:

* Follow the Sun Oracle [code conventions](http://www.oracle.com/technetwork/java/codeconv-138413.html)
* Include tests that fail without your code, and pass with it
* Update the documentation, the surrounding one, examples elsewhere, guides,
  whatever is affected by your contribution


And in case I didn't emphasize it enough: I love tests!
