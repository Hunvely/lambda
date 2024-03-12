-- 1. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오.

SELECT *
FROM team
ORDER BY team_name;

-- 2. 플레이어의 포지셔 종류를 나열하시오. 중복 제거하고 포지션이 없으면 빈공간으로 두시오.

SELECT DISTINCT POSITION
FROM PLAYER;

-- 3. 플레이어의 포지션 종류를 나열하시오. 중복 제거하고 포지션이 없으면 '신입'으로 기재하시오.

SELECT DISTINCT CASE WHEN POSITION = '' THEN '신입' ELSE POSITION END
FROM PLAYER;

-- 4. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 KO2입니다.

SELECT player_name, POSITION
FROM PLAYER
WHERE POSITION = 'GK'
  AND team_id = 'K02';

-- 4-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오.



-- 5. 수원팀에서 성이 고씨이고 키가 170이상인 선수를 출력하시오. 단 수원팀 ID는 KD2입니다.

SELECT *
FROM player
WHERE height >= 170
  AND player.player_name LIKE '고%'
  AND team_id = 'K02';

-- 5-1. 수원팀에서 성이 고씨이고 키가 170이상인 선수를 출력하시오.
