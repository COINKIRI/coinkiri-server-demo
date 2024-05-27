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

	// post, community, member, comment, like
	@Override
	public List<Community> findAllWithMemberAndCommentAndLike() {
		return queryFactory.selectFrom(community)
			.leftJoin(community.member).fetchJoin()
			.leftJoin(community.comments).fetchJoin()
			// .leftJoin(community.likes).fetchJoin() -> default_batch_fetch_size 설정으로 인해 fetchJoin() 사용하지 않음
			.fetch();
	}
}
