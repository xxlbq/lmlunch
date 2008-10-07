/* ¹ØÁª±í²éÑ¯ */

SELECT R.ROLE_ID ,R.ROLE_NAME ,U.USER_ID,U.USER_NAME FROM t_role R
LEFT OUTER JOIN t_user U ON R.ROLE_ID = U.USER_ROLE WHERE U.USER_ID IS NOT NULL

SELECT R.ROLE_ID ,R.ROLE_NAME ,U.USER_ID,U.USER_NAME FROM t_role R
LEFT OUTER JOIN t_user U ON R.ROLE_ID = U.USER_ROLE HAVING U.USER_ID IS NOT NULL


SELECT R.ROLE_ID ,R.ROLE_NAME ,U.USER_ID,U.USER_NAME FROM t_role R
LEFT OUTER JOIN t_user U ON R.ROLE_ID = U.USER_ROLE


/*   ÄÚÁ¬½ÓÏÈ°ÑËùÓÐÒªÁ¬½ÓµÄ±íÒ»¸ö¸öµÄÆ´½Ó³ÉÒ»¸ö¡°´ó±í¡±£¬
     Èç¹ûÖÐ¼äÓÐ±ðµÄÌõ¼þÏÞÖÆ£¬¿ÉÒÔÍ¨¹ýÏÞÖÆÌõ¼þ£¬Ëõ¼õ±íµÄÁÐÊýºÍÐÐÊýºó£¬
     ¼ÌÐøºÍ±ðµÄ±íÁ¬½Ó¡£Á¬½ÓµÄ×îºó£¬ÊÇÒ»Ð©²éÑ¯Ìõ¼þ£¬ÓÃÀ´ÏÞÖÆÕâ¸ö¡°´ó±í¡±µÄÐÐÊý¡£
     Èç¹ûÁ¬½ÓÖÐ,ÓÐÈÎºÎÒ»¸ö±í²»Æ¥ÅäÁ¬½ÓÌõ¼þ,ÄÇÃ´¸ÃÐÐÊý¾Ý½«²»»á³öÏÖÔÚ¡°´ó±í¡±ÖÐ */


SELECT R.ROLE_ID ,R.ROLE_NAME ,U.USER_ID,U.USER_NAME FROM t_role R
INNER JOIN t_user U ON R.ROLE_ID = U.USER_ROLE

SELECT R.ROLE_ID ,R.ROLE_NAME ,U.USER_ID,U.USER_NAME FROM t_role R
JOIN t_user U ON R.ROLE_ID = U.USER_ROLE



SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
JOIN t_user U 


SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
WHERE NOT EXISTS (
SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
INNER JOIN t_user U ON R.ROLE_ID = U.USER_ROLE

)


/*    UNION Êµ¼ÊÉÏÊÇ¶ÔÁ½¸ö·Ö±ð½øÐÐ×óÓÒÁ¬½Óºó£¬
      ÔÙ½«½á¹û¼¯ÁªºÏµ½Ò»¿éÐÎ³ÉµÄ.
      ½øÐÐÁªºÏµÄÁ½¸ö½á¹û¼¯µÄÁÐ±ØÐëÏàÍ¬.
      unionÖ»ÄÜÓÐÒ»¸öorder by×Ó¾ä£¬²¢ÇÒËü±ØÐëÎ»ÓÚunionµÄ×îºóÒ»ÐÐÖÐ¡£
      Õâ¸ö×Ó¾ä°´Ö¸¶¨Ë³Ðò¶ÔunionËùÓÐÐÐ½øÐÐÅÅÐò¡£
      unionÁªºÏÊ±£¬»áÉ¾³ýÖØ¸´µÄÐÐ£¬¶ø²»ÂÛÖØ¸´µÄÐÐÊÇ·ñÀ´×ÔÍ¬Ò»¸ö±í¡£

 */

SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
UNION 
SELECT R2.ROLE_ID ,R2.ROLE_NAME  FROM t_role_2 R2


/*     union all²»É¾³ýÖØ¸´µÄÐÐ£¬Ò²²»¶ÔÐÐ½øÐÐ×Ô¶¯ÅÅÐò¡£

*/

SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
UNION ALL
SELECT R2.ROLE_ID ,R2.ROLE_NAME  FROM t_role_2 R2



SELECT S.SOURCE_ID,S.SOURCE_NAME,S.SOURCE_FOOD_ID ,S.SOURCE_FOOD_COUNT,
S.INPUT_USER_ID,S.UPDATE_USER_ID,S.INPUT_DATETIME,S.UPDATE_DATETIME,
F.FOOD_NAME,F.FOOD_PRICE
FROM T_SOURCE AS S
LEFT JOIN T_FOOD AS F ON S.SOURCE_FOOD_ID = F.FOOD_ID




SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
JOIN
t_role_2 R2 

SELECT R.ROLE_ID ,R.ROLE_NAME  FROM t_role R
LEFT  JOIN
t_role_2 R2 ON R.ROLE_ID = R2.ROLE_ID