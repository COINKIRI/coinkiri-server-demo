package coinkiri.core.domain.post.repository.community;

import static coinkiri.core.domain.post.QCommunity.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;

import coinkiri.core.domain.post.Community;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunityRepositoryImpl implements CommunityRepositoryDsl {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Community> findAllWithMember() {
		return queryFactory.selectFrom(community)
			.leftJoin(community.member)
			.fetchJoin()
			.fetch();
	}
}
