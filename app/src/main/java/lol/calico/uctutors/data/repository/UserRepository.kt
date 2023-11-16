package lol.calico.uctutors.data.repository

import lol.calico.uctutors.data.source.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
  private val userRemoteDataSource: UserRemoteDataSource
) {

}