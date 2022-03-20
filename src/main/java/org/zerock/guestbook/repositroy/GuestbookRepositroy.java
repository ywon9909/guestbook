package org.zerock.guestbook.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookRepositroy extends JpaRepository<Guestbook, Long>, QuerydslPredicateExecutor<Guestbook> {
}
