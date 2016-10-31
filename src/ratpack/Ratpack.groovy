import ratpack.config.ConfigDataBuilder
import ratpack.groovy.template.MarkupTemplateModule
import asset.pipeline.ratpack.AssetPipelineModule
import asset.pipeline.ratpack.AssetPipelineHandler

import ratpack.config.ConfigData
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module MarkupTemplateModule

    ConfigData configData = ConfigData.builder().sysProps().build()
    AssetPipelineModule.Config config = configData.get(AssetPipelineModule.Config)
    config.sourcePath = "../../../src/assets"
    moduleConfig(new AssetPipelineModule(), config)
  }

  handlers {
    //Served by default from /assets or in this example from the root url
    all(AssetPipelineHandler)
  }
}
