# Deploy Hoplon Application to Heroku

An example project that uses Hoplon and Castra, with tasks to help you package
it up and deploy to Heroku. If you aren't familiar with how Heroku works you
may want to [check out their Getting Started docs][1].

## Start Local Dev Server

- When you're working on your app you can start a local server that will serve
  your app at http://localhost:8000 and recompile source files as necessary:

  ```
  $ boot development
  ```

- When you have everything working the way you want it, you're ready to
  compile with optimizations and deploy to Heroku. That's the next section.

## Deploy to Heroku

- Set up for heroku (only need to do this once):

  ```
  $ heroku create
  ```

- Build the hoplon html etc. and prepare deployment descriptors for Heroku:

  ```
  $ boot production heroku
  ```

- Commit changes and push to Heroku:

  ```
  $ git commit -a -m "working"
  $ git push heroku master
  ```

- Check the server logs in case of trouble:

  ```
  $ heroku logs --tail
  ```

[1]: https://devcenter.heroku.com/articles/getting-started-with-clojure

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
