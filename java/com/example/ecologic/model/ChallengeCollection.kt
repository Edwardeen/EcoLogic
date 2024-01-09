package com.example.ecologic.model

import androidx.compose.runtime.Immutable

@Immutable
data class ChallengeCollection(
    val id: Long,
    val name: String,
    val challenges: List<Challenge>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }

object ChallengeRepo {
    fun getChallenges(): List<ChallengeCollection> = challengeCollectionsList
    fun getChallengeId(challengeId: Long): Challenge = challenges.find { it.id == challengeId }!!

    fun getFilters() = filters
    fun getPriceFilters() = priceFilters
    fun getCart() = cart
    fun getSortFilters() = sortFilters
    fun getCategoryFilters() = categoryFilters
    fun getSortDefault() = sortDefault
    fun getLifeStyleFilters() = lifeStyleFilters
    fun getActiveChallenge() = activeChallenges
    
    fun getInactiveChallenge() = allChallenges

}

/**
 * Static data
 */

private val activeChallenges: ChallengeCollection = ChallengeCollection(
    id = 1L,
    name = "Active challenges",
    type = CollectionType.Highlight,
    challenges = challenges.subList(0, 13)
)

private val allChallenges: ChallengeCollection = ChallengeCollection(
    id = 2L,
    name = "All Challenges!",
    challenges = challenges.subList(0, 28)
)

private val inactiveChallenges: ChallengeCollection = ChallengeCollection(
    id = 3L,
    name = "Challenges that you can do!",
    challenges = allChallenges.challenges.filterNot { challenge ->
        activeChallenges.challenges.contains(challenge)
    }
)

private val challengeCollectionsList: List<ChallengeCollection> = listOf(
    activeChallenges,
    inactiveChallenges,
    allChallenges


)

private val cart = listOf(
    OrderLine(challenges[4], 2),
    OrderLine(challenges[6], 3),
    OrderLine(challenges[8], 1)
)

@Immutable
data class OrderLine(
    val Challenges: Challenge,
    val count: Int
)
