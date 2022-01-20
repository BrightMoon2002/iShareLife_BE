package com.example.isharelife.repository.relationship;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.relationship.RelationshipAccounts;
import com.example.isharelife.model.relationship.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IRelationshipAccountsRepository extends JpaRepository<RelationshipAccounts, Long> {
    Iterable<RelationshipAccounts> findAllByAccount2AndRelationshipTypeId(Account account2,Long id);

    Iterable<RelationshipAccounts> findAllByAccount1AndRelationshipTypeId(Account account1,Long id);

//    @Query(value = "select * from relationship_accounts where account1_id= :id1 and account2_id= :id2 ",nativeQuery = true)
//    Optional<RelationshipAccounts> findRelationship(@Param("id1") int id1,@Param("id2") int id2);
    Optional<RelationshipAccounts> findRelationshipAccountsByAccount1_IdAndAccount2_Id(Long id1,Long id2);

    @Modifying
    @Transactional
    @Query( value = "update accounts set is_show = !is_show where id = :id",nativeQuery = true)
    void changeIsShow(@Param("id") Long id);



//    @Modifying(clearAutomatically = true)
//    @Query(value = "update relationship_accounts set relationship_type_id = :Rid where id = :id",nativeQuery = true)
//    void changeRelationship(@Param("Rid") Long Rid,@Param("id") Long id);


}
