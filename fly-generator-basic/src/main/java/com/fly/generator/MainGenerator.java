package com.fly.generator;

import com.fly.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        // 静态生成
        //  获取项目路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        // 输入路径
        String inputPath = projectPath + File.separator + "fly-generator-demo-projects" + File.separator + "acm-template";
        System.out.println(inputPath);
        // 输出路径
        String targetPath = projectPath;
        //copyFilesByHutool(inputPath, targetPath);
        StaticGenerator.copyFilesByRecursive(inputPath, targetPath);

        // 动态生成
        String dynamicInputPath = projectPath + File.separator + "fly-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        MainTemplateConfig model = new MainTemplateConfig();
        model.setLoop(false);
        model.setOutputText("结果=");
        model.setAuthor("flycode");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, model);
    }

    public static void doGenerate(MainTemplateConfig mainTemplateConfig) throws IOException, TemplateException {
        String inputRootPath = "D:/fly/project/fly-generator/fly-generator/fly-generator-demo-projects/acm-template-pro";
        String outputRootPath = "generated";


        String inputPath;
        String outputPath;

        // 动态文件生成
        inputPath = new File(inputRootPath, "src/main/resources/templates/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/main/yupi/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, mainTemplateConfig);

        // 静态文件生成
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        inputPath = new File(inputRootPath, ".README").getAbsolutePath();
        outputPath = new File(outputRootPath, ".README").getAbsolutePath();
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
    }

    public static void doGenerateDepreated(MainTemplateConfig mainTemplateConfig) throws IOException, TemplateException {
        // 静态生成
        //  获取项目路径
        String projectPath = System.getProperty("user.dir");
        //System.out.println(projectPath);
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "fly-generator-demo-projects/acm-template").getAbsolutePath();
        //System.out.println(inputPath);
        // 输出路径
        String targetPath = projectPath;
        //copyFilesByHutool(inputPath, targetPath);
        StaticGenerator.copyFilesByRecursive(inputPath, targetPath);

        // 动态生成
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = targetPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";

        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
