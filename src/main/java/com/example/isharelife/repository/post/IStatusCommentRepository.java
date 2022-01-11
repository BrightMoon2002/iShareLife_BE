package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.StatusComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusCommentRepository extends JpaRepository<StatusComment,Long> {
}
