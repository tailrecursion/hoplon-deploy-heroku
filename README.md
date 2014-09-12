# Deploy Hoplon Application to Heroku

An example project that uses Hoplon and Castra, with tasks to help you package
it up and deploy to Heroku. If you aren't familiar with how Heroku works you
may want to [check out their Getting Started docs][1].

## Usage

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

Build for development with local Jetty server:

```
$ boot development
```

[1]: https://devcenter.heroku.com/articles/getting-started-with-clojure

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
