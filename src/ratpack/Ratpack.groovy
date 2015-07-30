import ratpack.groovy.template.MarkupTemplateModule
import asset.pipeline.ratpack.AssetPipelineModule
import asset.pipeline.ratpack.AssetPipelineHandler
import static ratpack.groovy.Groovy.groovyMarkupTemplate
import ratpack.config.ConfigData
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module MarkupTemplateModule
    ConfigData configData = ConfigData.of().sysProps().build()
    moduleConfig(new AssetPipelineModule(), configData.get(AssetPipelineModule.Config))

  }

  handlers {
    // get {
    //   render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    // }
    //Served by default from /assets or in this example from the root url
    all(AssetPipelineHandler)
  }
}
