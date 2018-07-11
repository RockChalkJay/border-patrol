# border-patrol

ABANDONED

Original, this project was meant to be an oAuth 2 (Three Legged) server written in 
clojure. However, it later became a project to investigate libraries packaged with the 
[Luminus][1] "framework".  

I've cherry picked a few of the libs and have used in other projects. 

[struct][2] - validation. However, I could of probably got away with spec

[mount][3] - state management. You can do all kinds of fun stuff like re-initialize DB connections,
reload a config file and lots more without bouncing the server. 

[conman][4] - database connection management

[liberator][5] - A great library for defining endpoints to your data in a RESTful way.
Uses a decesion graph to determine the status code returned from a request. Much better
than Compojure API.

## Prerequisites

You will need [Leiningen][11] 2.0 or above installed.



## Running

To start a web server for the application, run:

    lein run 
    
## TODO

* Error handling around user sign up
* Sign up post re-directs
* Clean up/style sign up page
* How should the auth service work? return an http response or some map of results

## License

Copyright © 2018 RockChalk Software, LLC

[1]: http://www.luminusweb.net/
[2]: https://github.com/funcool/struct
[3]: https://github.com/tolitius/mount
[4]: https://github.com/luminus-framework/conman
[5]: http://clojure-liberator.github.io/liberator/
[11]: https://github.com/technomancy/leiningen
