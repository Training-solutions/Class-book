package com.eschool.classbook;

import com.eschool.classbook.credential.CredentialRepository;
import com.eschool.classbook.group.GroupRepository;
import com.eschool.classbook.mark.MarkRepository;
import com.eschool.classbook.student.StudentRepository;
import com.eschool.classbook.subject.SubjectRepository;
import com.eschool.classbook.teacher.TeacherRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(
        classes = ClassBookIntegrationConfigurationSupport.class
)
@Sql(
        scripts = {"classpath:sql/data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public abstract class BaseIntegrationTest {
    public StudentRepository studentRepository;
    public GroupRepository groupRepository;
    public SubjectRepository subjectRepository;
    public TeacherRepository teacherRepository;
    private MarkRepository markRepository;
    public CredentialRepository credentialRepository;

    @Autowired
    public final void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public final void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Autowired
    public final void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Autowired
    public final void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public final void setScoreRepository(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Autowired
    public final void setCredentialRepository(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @After
    public void clean(){
        //needs to be the first one
        studentRepository.deleteAll();

        groupRepository.deleteAll();
        teacherRepository.deleteAll();
        subjectRepository.deleteAll();
        markRepository.deleteAll();

        //needs to be the last
        credentialRepository.deleteAll();
    }

    @SuppressWarnings("rawtypes")
    private static PostgreSQLContainer postgreSQLContainer;


    static {
        DockerImageName postgres = DockerImageName.parse("postgres:13.1");
        postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer(postgres).withReuse(true);
        postgreSQLContainer.start();
    }

    @SuppressWarnings("unused")
    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry propertyRegistry) {
        String jdbcUrl = postgreSQLContainer.getJdbcUrl();
        propertyRegistry.add("integration-tests-db", postgreSQLContainer::getDatabaseName);
        propertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        propertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        propertyRegistry.add("spring.datasource.url", () -> jdbcUrl);
    }
}
