# Deploy Hoplon Application to Heroku

An example project that uses Hoplon and Castra, with tasks to help you package
it up and deploy to Heroku.

## Usage

- Build the hoplon html etc. and prepare deployment descriptors for Heroku:

  ```
  $ boot production heroku
  ```

- Commit changes and push to Heroku:

  ```
  $ git commit -a -m "working" && git push heroku master
  ```

Build for development with local Jetty server:

```
$ boot development
```

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
