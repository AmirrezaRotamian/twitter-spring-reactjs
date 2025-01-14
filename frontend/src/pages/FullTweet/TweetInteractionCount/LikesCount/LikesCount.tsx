import React, { memo, ReactElement } from "react";
import { useSelector } from "react-redux";
import Typography from "@material-ui/core/Typography";

import UsersListModal, { UsersListModalAction } from "../../../../components/UsersListModal/UsersListModal";
import { selectLikesCount, selectTweetId } from "../../../../store/ducks/tweet/selectors";
import { useFullTweetStyles } from "../../FullTweetStyles";
import { useModalWindow } from "../../../../hook/useModalWindow";

const LikesCount = memo((): ReactElement => {
    const classes = useFullTweetStyles();
    const tweetId = useSelector(selectTweetId);
    const likesCount = useSelector(selectLikesCount);
    const { visibleModalWindow, onOpenModalWindow, onCloseModalWindow } = useModalWindow();

    return (
        <>
            {(likesCount !== 0) && (
                <span className={classes.interactionCount} onClick={onOpenModalWindow}>
                    <div className={classes.contentItem}>
                        <Typography variant={"h6"} component={"span"}>
                            {likesCount}
                        </Typography>
                        <Typography variant={"subtitle1"} component={"span"}>
                            Likes
                        </Typography>
                    </div>
                </span>
            )}
            <UsersListModal
                tweetId={tweetId!}
                usersListModalAction={UsersListModalAction.LIKED}
                visible={visibleModalWindow}
                onClose={onCloseModalWindow}
            />
        </>
    );
});

export default LikesCount;
