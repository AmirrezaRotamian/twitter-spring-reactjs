package com.gmail.merikbest2015.mapper;

import com.gmail.merikbest2015.TweetServiceTestHelper;
import com.gmail.merikbest2015.commons.mapper.BasicMapper;
import com.gmail.merikbest2015.dto.request.TweetRequest;
import com.gmail.merikbest2015.dto.request.VoteRequest;
import com.gmail.merikbest2015.commons.dto.response.tweet.TweetResponse;
import com.gmail.merikbest2015.model.Tweet;
import com.gmail.merikbest2015.repository.projection.TweetProjection;
import com.gmail.merikbest2015.service.PollService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PollMapperTest {

    @InjectMocks
    private PollMapper pollMapper;

    @Mock
    private BasicMapper basicMapper;

    @Mock
    private PollService pollService;

    @Test
    public void createPoll() {
        TweetRequest tweetRequest = new TweetRequest();
        Tweet tweet = new Tweet();
        TweetResponse tweetResponse = new TweetResponse();
        when(basicMapper.convertToResponse(tweetRequest, Tweet.class)).thenReturn(tweet);
        when(pollService.createPoll(tweetRequest.getPollDateTime(), tweetRequest.getChoices(), tweet)).thenReturn(tweetResponse);
        assertEquals(tweetResponse, pollMapper.createPoll(tweetRequest));
        verify(basicMapper, times(1)).convertToResponse(tweetRequest, Tweet.class);
        verify(pollService, times(1)).createPoll(tweetRequest.getPollDateTime(), tweetRequest.getChoices(), tweet);
    }

    @Test
    public void voteInPoll() {
        TweetResponse tweetResponse = new TweetResponse();
        VoteRequest voteRequest = new VoteRequest();
        TweetProjection tweetProjection = TweetServiceTestHelper.createTweetProjection(false, TweetProjection.class);
        when(pollService.voteInPoll(voteRequest.getTweetId(), voteRequest.getPollId(), voteRequest.getPollChoiceId())).thenReturn(tweetProjection);
        when(basicMapper.convertToResponse(tweetProjection, TweetResponse.class)).thenReturn(tweetResponse);
        assertEquals(tweetResponse, pollMapper.voteInPoll(voteRequest));
        verify(pollService, times(1)).voteInPoll(voteRequest.getTweetId(), voteRequest.getPollId(), voteRequest.getPollChoiceId());
        verify(basicMapper, times(1)).convertToResponse(tweetProjection, TweetResponse.class);
    }
}
