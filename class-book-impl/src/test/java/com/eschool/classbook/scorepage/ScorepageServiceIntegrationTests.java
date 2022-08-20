package com.eschool.classbook.scorepage;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialRepository;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.group.GroupRepository;
import com.eschool.classbook.group.GroupService;
import com.eschool.classbook.score.Score;
import com.eschool.classbook.score.ScoreEntity;
import com.eschool.classbook.score.ScoreService;
import com.eschool.classbook.student.StudentRepository;
import com.eschool.classbook.subject.SubjectRepository;
import com.eschool.classbook.teacher.TeacherRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Objects;

import static org.junit.Assert.*;

@Sql(
        scripts = {"classpath:sql/data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)

public class ScorepageServiceIntegrationTests extends BaseIntegrationTest {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @After
    public void clean() {
        groupRepository.deleteAll();
        studentRepository.deleteAll();
        subjectRepository.deleteAll();
        teacherRepository.deleteAll();
        credentialRepository.deleteAll();
    }

    @Test
    public void givenScorepage_whenSave_thenReturnSuccessfulResult() {
        //given
        ScoreEntity expected = TestData.getScore();

        //when
        ScoreEntity actual = scoreService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getScore(), actual.getScore());
        assertEquals(expected.getId(), actual.getId());
        assertFalse(expected.isDeleted());
        assertTrue(expected.getSubjects().isEmpty());

    }

    @Test
    public void givenScorepage_whenFindById_thenReturnSuccessfulResult() {
        //when
        ScoreEntity actual = scoreService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals(10, actual.getScore());
        assertFalse(actual.isDeleted());

    }

    @Test
    public void givenScorepage_whenFindById_thenExceptionThrows() {
        //given
        Long failedId = 999L;

        //when
        scoreService.findById(failedId);

        //then
        assertThrows(String.format("Score with id %d was not found", failedId),
                ClassBookException.class,
                () -> scoreService.findById(failedId));
    }

    @Test
    public void givenScorepage_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        scoreService.deleteById(id);

        //then
        ScoreEntity scoreEntity = scoreService.findById(id);
        assertTrue(scoreEntity.isDeleted());

    }

    @Test
    public void givenScorepage_whenFindAll_thenFoundGroupListSuccessfully(){
        //when
        Page<ScoreEntity> scores = scoreService.findAll(PageRequest.of(1, 3));

        //then
        assertEquals(1, scores.getTotalPages());
        assertEquals(3, scores.getTotalElements());
        assertTrue(scores.stream().allMatch(Objects::nonNull));

    }

    @Test
    public void givenScorepage_whenUpdate_thenUpdatedSuccessfully(){
        //given

        Score score = Score.ONE;
        ScoreEntity expected = scoreService.findById(1L);
        expected.setScore(score);

        //when
        scoreService.update(1L, expected);

        //then
        assertEquals(expected.getScore(), score);

    }

}
