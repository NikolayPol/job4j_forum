package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Класс PostControlTest
 *
 * @author Nikolay Polegaev
 * @version 2.0 19.12.2021
 */
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    public void createTest() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    void saveOrUpdateTest() throws Exception {
        this.mockMvc.perform(post("/saveOrUpdate")
                .param("name","Тема")
                .param("description", "Описание"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));
        verify(postService, times(1)).saveOrUpdate(any());

        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).saveOrUpdate(argument.capture());
        assertThat(argument.getValue().getName(), is("Тема"));
        assertThat(argument.getValue().getDescription(), is("Описание"));
    }

    @Test
    @WithMockUser
    void updateTest() throws Exception {
        this.mockMvc.perform(post("/update")
                .param("id","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
        verify(postService, times(1)).findById(anyInt());

        ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
        verify(postService).findById(argument.capture());
    }

    @Test
    @WithMockUser
    void deleteTest() throws Exception {
        this.mockMvc.perform(post("/delete")
                .param("id","1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));
        verify(postService, times(1)).delete(anyInt());

        ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
        verify(postService).delete(argument.capture());
    }

}