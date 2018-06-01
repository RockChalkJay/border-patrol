# border-patrol


oAuth 2 (Three Legged) server written in clojure.

Many of the imports/plug-ins/frameworks, etc. were chosen for academic reasons. I'm a firm believer in choosing the right tool for the job. However, the right tools in this case are technologies I want to learn. :)

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

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
