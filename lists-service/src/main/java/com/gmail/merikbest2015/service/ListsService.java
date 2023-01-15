package com.gmail.merikbest2015.service;

import com.gmail.merikbest2015.commons.dto.HeaderResponse;
import com.gmail.merikbest2015.commons.dto.TweetResponse;
import com.gmail.merikbest2015.dto.request.UserToListsRequest;
import com.gmail.merikbest2015.commons.models.Lists;
import com.gmail.merikbest2015.repository.projection.*;
import com.gmail.merikbest2015.repository.projection.pinned.PinnedListProjection;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ListsService {

    List<ListProjection> getAllTweetLists();

    List<ListUserProjection> getUserTweetLists();

    List<PinnedListProjection> getUserPinnedLists();

    BaseListProjection getListById(Long listId);

    ListUserProjection createTweetList(Lists lists);

    List<ListProjection> getUserTweetListsById(Long userId);

    List<ListProjection> getTweetListsWhichUserIn();

    BaseListProjection editTweetList(Lists lists);

    String deleteList(Long listId);

    ListUserProjection followList(Long listId);

    PinnedListProjection pinList(Long listId);

    List<Map<String, Object>> getListsToAddUser(Long userId);

    String addUserToLists(UserToListsRequest userToListsRequest);

    Map<String, Object> addUserToList(Long userId, Long listId);

    HeaderResponse<TweetResponse> getTweetsByListId(Long listId, Pageable pageable);

    BaseListProjection getListDetails(Long listId);

    List<ListMemberProjection> getListFollowers(Long listId, Long listOwnerId);

    Map<String, Object> getListMembers(Long listId, Long listOwnerId);

    List<Map<String, Object>> searchListMembersByUsername(Long listId, String username);
}