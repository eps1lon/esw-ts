import type { Failed } from '../../../models/common'

export type Spawned = {
  _type: 'Spawned'
}

export type Killed = {
  _type: 'Killed'
}

export type SpawnResponse = Spawned | Failed
export type KillResponse = Killed | Failed
