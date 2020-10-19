import type { Done } from '../..'
import { gatewayConnection, resolveConnection } from '../../config/Connections'
import { HttpTransport } from '../../utils/HttpTransport'
import { getPostEndPoint } from '../../utils/Utils'
import { AlarmServiceImpl } from './AlarmServiceImpl'
import type { AlarmKey, AlarmSeverity } from './models/PostCommand'

/**
 * @category Service
 */
export interface AlarmService {
  setSeverity(alarmKey: AlarmKey, severity: AlarmSeverity): Promise<Done>
}

export const AlarmService = async (): Promise<AlarmService> => {
  const { host, port } = await resolveConnection(gatewayConnection)
  const url = getPostEndPoint({ host, port })
  return new AlarmServiceImpl(new HttpTransport(url))
}
