package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import py.com.jaha.api.establishments.domain.models.establishments.Category;
import py.com.jaha.api.establishments.domain.models.establishments.Establishment;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Categories;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Establishments;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-10T17:18:58-0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class EstablishmentsMapperImpl implements EstablishmentsMapper {

    @Override
    public Establishment toDomain(Establishments entity) {
        if ( entity == null ) {
            return null;
        }

        Establishment establishment = new Establishment();

        establishment.setId( entity.getId() );
        establishment.setName( entity.getName() );
        establishment.setShortDescription( entity.getShortDescription() );
        establishment.setLongDescription( entity.getLongDescription() );
        establishment.setProfileImagePath( entity.getProfileImagePath() );
        establishment.setFrontPageImagePath( entity.getFrontPageImagePath() );
        establishment.setProfileMiniImagePath( entity.getProfileMiniImagePath() );
        establishment.setFrontMiniPageImagePath( entity.getFrontMiniPageImagePath() );
        establishment.setCategory( categoriesToCategory( entity.getCategory() ) );
        establishment.setCreatedAt( entity.getCreatedAt() );
        establishment.setUpdatedAt( entity.getUpdatedAt() );

        return establishment;
    }

    @Override
    public Establishments toEntity(Establishment domain) {
        if ( domain == null ) {
            return null;
        }

        Establishments establishments = new Establishments();

        establishments.setId( domain.getId() );
        establishments.setName( domain.getName() );
        establishments.setShortDescription( domain.getShortDescription() );
        establishments.setLongDescription( domain.getLongDescription() );
        establishments.setProfileImagePath( domain.getProfileImagePath() );
        establishments.setFrontPageImagePath( domain.getFrontPageImagePath() );
        establishments.setProfileMiniImagePath( domain.getProfileMiniImagePath() );
        establishments.setFrontMiniPageImagePath( domain.getFrontMiniPageImagePath() );
        establishments.setCreatedAt( domain.getCreatedAt() );
        establishments.setUpdatedAt( domain.getUpdatedAt() );
        establishments.setCategory( categoryToCategories( domain.getCategory() ) );

        return establishments;
    }

    @Override
    public List<Establishment> toDomainList(List<Establishments> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Establishment> list = new ArrayList<Establishment>( entities.size() );
        for ( Establishments establishments : entities ) {
            list.add( toDomain( establishments ) );
        }

        return list;
    }

    @Override
    public List<Establishments> toEntityList(List<Establishment> domains) {
        if ( domains == null ) {
            return null;
        }

        List<Establishments> list = new ArrayList<Establishments>( domains.size() );
        for ( Establishment establishment : domains ) {
            list.add( toEntity( establishment ) );
        }

        return list;
    }

    protected Category categoriesToCategory(Categories categories) {
        if ( categories == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categories.getId() );
        category.setName( categories.getName() );
        category.setImageAppPath( categories.getImageAppPath() );
        category.setImageWebPath( categories.getImageWebPath() );
        category.setCreatedAt( categories.getCreatedAt() );
        category.setUpdatedAt( categories.getUpdatedAt() );

        return category;
    }

    protected Categories categoryToCategories(Category category) {
        if ( category == null ) {
            return null;
        }

        Categories categories = new Categories();

        categories.setId( category.getId() );
        categories.setName( category.getName() );
        categories.setImageAppPath( category.getImageAppPath() );
        categories.setImageWebPath( category.getImageWebPath() );
        categories.setCreatedAt( category.getCreatedAt() );
        categories.setUpdatedAt( category.getUpdatedAt() );

        return categories;
    }
}
