package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.builders.SessionBuilder;
import de.stephannaegele.ponyVote.model.Session;
import de.stephannaegele.ponyVote.services.SessionService;
import de.stephannaegele.ponyVote.views.SessionView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SessionControllerTest {

    @Mock
    private SessionService sessionService;

    @Mock
    Model model;

    private SessionController sessionController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sessionController = new SessionController(sessionService);
    }

    @Test
    public void getSessions() {
    }

    @Test
    public void createValidSessionWithoutItems() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(sessionController).build();
        Session session = new SessionBuilder().withRandomId().withItems(5).get();

        SessionView sessionView = new SessionView(session);

        when(sessionService.save(Mockito.any())).thenReturn(session);

        mockMvc.perform(put("/session/", sessionView))
                .andExpect(status().isOk())
                .andExpect(view().name("session/" + session.getId().toString()));

        verify(sessionService, times(1)).save(Mockito.any());
    }


}