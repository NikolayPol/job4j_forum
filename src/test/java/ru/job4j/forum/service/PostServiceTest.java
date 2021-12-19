package ru.job4j.forum.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Класс PostServiceTest
 *
 * @author Nikolay Polegaev
 * @version 1.0 19.12.2021
 */
@SpringBootTest(classes = Main.class)
class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @Mock
    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostService(postRepository);
    }

    @Test
    void getAllTest() {
        List<Post> posts = List.of(
                Post.of(1, "Тема1", "Описание1"),
                Post.of(2, "Тема2", "Описание2"),
                Post.of(3, "Тема3", "Описание3")
        );

        when(postRepository.findAll()).thenReturn(posts);

        List<Post> returnPosts = postService.getAll();
        assertEquals(returnPosts.get(0).getId(), 1);
        assertEquals(returnPosts.get(1).getId(), 2);
        assertEquals(returnPosts.get(2).getId(), 3);
        assertEquals(returnPosts.get(0).getName(), "Тема1");
        assertEquals(returnPosts.get(1).getName(), "Тема2");
        assertEquals(returnPosts.get(2).getName(), "Тема3");
        assertEquals(returnPosts.get(0).getDescription(), "Описание1");
        assertEquals(returnPosts.get(1).getDescription(), "Описание2");
        assertEquals(returnPosts.get(2).getDescription(), "Описание3");
    }

    @Test
    void findByIdTest() {
        Post post = Post.of(1, "Тема", "Описание");
        when(postRepository.findById(1)).thenReturn(Optional.of(post));

        Post returnPost = postService.findById(1);
        assertEquals(returnPost.getId(), 1);
        assertEquals(returnPost.getName(), "Тема");
        assertEquals(returnPost.getDescription(), "Описание");
    }

    @Test
    void saveOrUpdateTest() {
        Post post = Post.of(1, "Тема", "Описание");
        when(postRepository.save(post)).thenReturn(post);

        postService.saveOrUpdate(post);

        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postRepository, times(1)).save(argument.capture());

    }

    @Test
    void deleteTest() {
        Post post = Post.of(1, "Тема", "Описание");
        when(postRepository.findById(1)).thenReturn(Optional.of(post));

        postService.delete(1);

        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postRepository, times(1)).findById(1);
        verify(postRepository, times(1)).delete(argument.capture());

    }

}