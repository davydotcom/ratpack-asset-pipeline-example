# Ratpack Asset Pipeline Example

This is a sample app serving static assets from the ratpack service.
By Default the `AssetPipelineModule` will register a Handler to serve assets from the `/assets` url prefix. 

In this example, however, we show how easy it is to use the `AssetPipelineHandler` in your handler chain to serve assets from the root path as well.