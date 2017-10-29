package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.builders.SessionBuilder;
import de.stephannaegele.ponyVote.domain.Session;
import de.stephannaegele.ponyVote.repository.SessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SessionServiceTest {

    @Mock
    private SessionRepository sessionRepository;
    private SessionService sessionService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.sessionService = new SessionService(sessionRepository);
    }

    @Test
    public void getSession() throws Exception {

        final Long SESSION_TEST_ID = 4L;

        Session session = new SessionBuilder().withId(SESSION_TEST_ID).withItems(4).get();
        when(sessionRepository.findById(SESSION_TEST_ID))
                              .thenReturn(java.util.Optional.ofNullable(session));

        assertTrue(sessionService.getSession(SESSION_TEST_ID).getId().equals(SESSION_TEST_ID));
    }

    @Test
    public void getSessions() throws Exception {
    }

}