package com.krtopi.backend.user.friend;

import com.krtopi.backend.user.UserEntity;
import jakarta.persistence.*;

@Table(name = "friend_status")
@Entity
public class FriendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "friend_status_id")
    private Long id;

    private FriendStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private UserEntity sentUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private UserEntity receivedUser;
}
