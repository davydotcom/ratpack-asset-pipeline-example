import ratpack.groovy.template.MarkupTemplateModule
import asset.pipeline.ratpack.AssetPipelineModule
import asset.pipeline.ratpack.AssetPipelineHandler
import static ratpack.groovy.Groovy.groovyMarkupTemplate
import ratpack.config.ConfigData
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module MarkupTemplateModule
    module(AssetPipelineModule) {
        println it.dump()
        it.url("/")
        it.sourcePath("../../../src/assets") // FIXME: With this, it works with ./gradlew run - but not with shadowJar
    }
  }

  handlers {
    // get {
    //   render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    // }
    //Served by default from /assets or in this example from the root url
    all(AssetPipelineHandler)
  }
}
