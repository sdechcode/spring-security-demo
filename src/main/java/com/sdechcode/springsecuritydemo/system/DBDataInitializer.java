package com.sdechcode.springsecuritydemo.system;

import com.sdechcode.springsecuritydemo.api.document.DocxNaiveTextReplacer;
import com.sdechcode.springsecuritydemo.api.document.KhmerlangClient;
import com.sdechcode.springsecuritydemo.api.document.TikaAnalysis;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangRequestDto;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangResponseDto;
import com.sdechcode.springsecuritydemo.entity.*;
import com.sdechcode.springsecuritydemo.repo.*;
import com.sdechcode.springsecuritydemo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@Slf4j
@Profile("dev")
public class DBDataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocxNaiveTextReplacer docxNaiveTextReplacer;
//    @Autowired
//    private KhmerlangClient khmerlangClient;

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

        // Test generate certificate
        //docxNaiveTextReplacer.replaceText();

        // Test khmerlang client
        /*KhmerLangRequestDto khmerLangRequestDto = new KhmerLangRequestDto("សេចក្តីដូចមានចែងក្នុងកម្មវត្ថនិងយោងខាងលើខ្ញុំបាទមានកិត្តិយសសូមគោរពជម្រាបជូន ឯកឧត្តមរដ្ឋមន្ត្រី មេត្តាជ្រាបដ៏ខ្ពង់ខ្ពស់ថាកាលពីថ្ងៃទី២1 ដល់ថ្ងៃទី២3 ខែឧសភា ឆ្នាំ២០២4 ឯកឧត្តម ចាន់ទី សុធី បានដឹកនាំក្រុមការងារតំណាងអោយ គ.រ.ឌ អមដំណើរដោយលោក ភី អ៊ីឃាង និងខ្ញុំបាទ ស៊ឹន វិសិទ្ធិបូទី ចូលរួមសន្និសីទ E-Governance Conference 2024 ក្រោមប្រធានបទ “Unlock Digital Success” នៅទីក្រុងតាទូ ប្រទេសអេស្តូនី។ សន្និសីទ E-Governance Conference 2024 ត្រូវបានរៀបចំឡើងដោយក្រសួងការបរទេសអេស្តូនី និងមជ្ឈមណ្ឌល Estonian Centre for International Development (ESTDEV) ក្នុងគោលបំណងជំរុញកិច្ចសហប្រតិបត្តិការជាសាកល និងការចែករំលែកចំណេះដឹងក្នុងចំណោមអ្នកដឹកនាំ និងអ្នកអនុវត្តបរិវត្តកម្មឌីជីថល។ សន្និសីទនេះបម្រើជាវេទិកាមួយដើម្បីពិភាក្សា ចែករំលែក និងស្វែងយល់អំពីវឌ្ឍនភាពចុងក្រោយបង្អស់ បញ្ហាប្រឈម និងឱកាសក្នុងការធ្វើអភិបាលកិច្ចឌីជីថលនៅប្រទេសផ្សេងៗ ដែលមានចំនួនចូលរួម 500នាក់មកពី 67ប្រទេស វាគ្មិន 71នាក់ មកពីទ្វីបចំនួន 5នៅទូទាំង 20ប្រទេស និងតំណាងមកពីអង្គការអន្តរជាតិចំនួន 4។ សន្និសីទនេះត្រូវបានចូលរួមដោយវាគ្មិនសំខាន់ៗដែលជាអ្នកដឹកនាំក្នុងវិស័យអភិបាលកិច្ចឌីជីថល និងបរិវត្តកម្មឌីជីថលពីថ្នាក់ដឹកនាំរដ្ឋាភិបាលដូចជាប្រធានាធិបតីអេស្តូនី រដ្ឋមន្រ្តីក្រសួងបរិវត្តកម្មឌីជីថលអ៊ុយក្រែន រដ្ឋមន្ត្រីក្រសួងអភិវឌ្ឍន៍ឌីជីថលកៀហ្ស៊ីស៊ី រហូតដល់នាយកប្រតិបត្តិ និងបណ្ឌិតសភា។ វាគ្មិនទាំងនេះបានបង្ហាញពីស្ថានភាពយុទ្ធសាស្ត្រនិងផែនការបរិវត្តកម្មឌីជីថលរបស់ប្រទេសនីមួយៗ ដោយផ្តោតលើការ បង្កើនគុណភាពសេវាសាធារណៈឌីជីថល ពង្រឹងការគ្រប់គ្រងទិន្នន័យ ជំរុញការអនុវត្តប្រព័ន្ធអត្តសញ្ញាណឌីជីថល និងពង្រឹងសុវត្ថិភាពឌីជីថល(Cybersecurity)។ លើសពីនេះ សន្និសីទបានពិភាក្សាអំពីតួនាទីរបស់បញ្ញាសិប្បនិមិត្ត (AI) ក្នុងការលើកកម្ពស់សេវាសាធារណៈឌីជីថលនិងជំរុញគំនិតច្នៃប្រឌិត រូមផ្សំនិងសារៈសំខាន់នៃអន្តរប្រតិបត្តិការប្រព័ន្ធ និងការចូលរួមពីប្រជាពលរដ្ឋ ក្នុងការរៀបចំយុទ្ធសាស្រ្តអភិបាលកិច្ចឌីជីថល។ ប្រធានបទ “Unlock Digital Success” ផ្តោតលើ: សំខាន់នៃការច្នៃប្រឌិត ការសម្របខ្លួន និងការរៀនសូត្រជាបន្ត ក្នុងការប្រឈមមុខនឹងការរីកចំរើនយ៉ាងឆាប់រហ័សនៃបច្ចេកវិទ្យា និងការផ្លាស់ប្តូរភូមិសាស្ត្រនយោបាយ។", false);
        log.info("Khmerlang request {} ", khmerLangRequestDto);
        KhmerLangResponseDto khmerLangResponseDto = khmerlangClient.wordSegmentation(khmerLangRequestDto);
        log.info("Khmerlang response {} ", khmerLangResponseDto);*/

        // Test Json util
       /* String res = JsonUtil.object2Json(u2);
        log.info("Object to Json {} ", res);*/

        // Test Tika
        InputStream stream = this.getClass().getClassLoader()
                .getResourceAsStream("khmerText.txt");
        String metadata = TikaAnalysis.extractContentUsingParser(stream);
        System.out.println(metadata.isBlank());
        System.out.println(metadata.isEmpty());
        System.out.println("Detected document type: " + metadata);
    }

}
