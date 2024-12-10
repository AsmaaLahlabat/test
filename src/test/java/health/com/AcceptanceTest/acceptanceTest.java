package health.com.AcceptanceTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cases", // المسار إلى ملفات الـ feature
        glue = "health.com.AcceptanceTest", // المسار إلى Step Definitions
        monochrome = true, // لجعل الإخراج في الكونسول أكثر وضوحًا
        snippets = CucumberOptions.SnippetType.CAMELCASE // لإنشاء الكود بشكل CamelCase
)
public class acceptanceTest {
    // لا حاجة لتعريف أي دوال هنا، يتم تشغيل هذا الكلاس لتشغيل الـ features
}


