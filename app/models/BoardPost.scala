package models

import java.time.Instant

case class BoardPost(
  id: Option[Long],
  name: String,
  message: String,
  ipAddress: String,
  createdAt: Instant
)
