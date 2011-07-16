package grails.plugin.redis

class RedisTagLib {

    def redisService

    static namespace = "redis"

    def memoize = { attrs, body ->
        String key = attrs.key
        if (!key) throw new IllegalArgumentException("[key] attribute must be specified for memoize!")

        Integer expire = attrs.expire?.toInteger()

        out << redisService.memoize(key, expire) { body() ?: "" }
    }
}
