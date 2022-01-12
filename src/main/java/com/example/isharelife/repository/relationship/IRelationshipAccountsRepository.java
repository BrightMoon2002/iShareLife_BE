package com.example.isharelife.repository.relationship;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.relationship.RelationshipAccounts;
import com.example.isharelife.model.relationship.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRelationshipAccountsRepository extends JpaRepository<RelationshipAccounts, Long> {
    Iterable<RelationshipAccounts> findAllByAccount2AndRelationshipTypeId(Account account2,Long id);

    Iterable<RelationshipAccounts> findAllByAccount1AndRelationshipTypeId(Account account1,Long id);

    Optional<RelationshipAccounts> findByAccount1IdAndAccount2Id(Long id1,Long id2);
    @Modifying(clearAutomatically = true)
    @Query(value = "update relationship_accounts set relationship_type_id = :Rid where id = :id",nativeQuery = true)
    void changeRelationship(@Param("Rid") Long Rid,@Param("id") Long id);
}
