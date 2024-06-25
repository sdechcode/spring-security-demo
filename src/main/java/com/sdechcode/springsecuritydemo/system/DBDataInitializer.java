package com.sdechcode.springsecuritydemo.system;

import com.sdechcode.springsecuritydemo.entity.*;
import com.sdechcode.springsecuritydemo.repo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@Profile("dev")
public class DBDataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create categories
        CategoryEntity c1 = new CategoryEntity();
        c1.setName("Cat 1");
        c1.setDescription("Cat 1 Des");

        CategoryEntity c2 = new CategoryEntity();
        c2.setName("Cat 2");
        c2.setDescription("Cat 2 Des");

        this.categoryRepository.saveAll(List.of(c1, c2));

        // Create sub-categories
        SubCategoryEntity s1 = new SubCategoryEntity();
        s1.setName("Sub 1");
        s1.setDescription("Sub 1 Des");

        SubCategoryEntity s2 = new SubCategoryEntity();
        s2.setName("Sub 2");
        s2.setDescription("Sub 2 Des");

        this.subCategoryRepository.saveAll(List.of(s1, s2));

        // Create posts
        PostEntity p1 = new PostEntity();
        p1.setTitle("Post 1");
        p1.setContent("Post 1 Content");
        p1.setImage("Post 1 Image");

        PostEntity p2 = new PostEntity();
        p2.setTitle("Post 2");
        p2.setContent("Post 2 Content");
        p2.setImage("Post 2 Image");

        this.postRepository.saveAll(List.of(p1, p2));

        // Create tags
        TagEntity t1 = new TagEntity();
        t1.setName("Tag 1");

        TagEntity t2 = new TagEntity();
        t2.setName("Tag 2");

        this.tagRepository.saveAll(List.of(t1, t2));

        // Create templates
        TemplateEntity tem1 = new TemplateEntity();
        tem1.setName("Template 1");
        tem1.setDescription("Template 1 Des");
        tem1.setFile("Template1.docx");

        TemplateEntity tem2 = new TemplateEntity();
        tem2.setName("Template 2");
        tem2.setDescription("Template 2 Des");
        tem2.setFile("Template2.docx");

        this.templateRepository.saveAll(List.of(tem1, tem2));

        // Create users
        UserEntity u1 = new UserEntity();
        u1.setUsername("Dara");
        u1.setPassword("1111");
        u1.setEnabled(true);
        u1.setRoles("admin designer user");

        UserEntity u2 = new UserEntity();
        u2.setUsername("Sokha");
        u2.setPassword("2222");
        u2.setEnabled(true);
        u2.setRoles("user");

        this.userRepository.saveAll(List.of(u1,u2));
    }

}
